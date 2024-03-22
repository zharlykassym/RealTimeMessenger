package com.tamerlan.realtimemessenger.viewmodule;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tamerlan.realtimemessenger.User;

public class RegistrationViewModel extends ViewModel {
    private FirebaseAuth mAuth;
    public MutableLiveData<String> error = new MutableLiveData<>();
    public MutableLiveData<FirebaseUser> user = new MutableLiveData<>();

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference usersReferences;

    public RegistrationViewModel() {
        mAuth = FirebaseAuth.getInstance();
        mAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    user.setValue(firebaseAuth.getCurrentUser());
                }
            }
        });
        firebaseDatabase = FirebaseDatabase.getInstance();
        usersReferences = firebaseDatabase.getReference("Users");
    }

    public LiveData<String> getError() {
        return error;
    }

    public MutableLiveData<FirebaseUser> getUser() {
        return user;
    }

    public void signUp(
            String email,
            String password,
            String name, String lastName,
            int age
    ) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                FirebaseUser firebaseUser = authResult.getUser();
                if (firebaseUser != null) {
                    User user = new User(
                            firebaseUser.getUid(),
                            name,
                            lastName,
                            age,
                            false);
                    usersReferences.child(user.getId()).setValue(user);
                }

            }
        })
                .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                error.setValue(e.getMessage());
            }
        });
    }

}
