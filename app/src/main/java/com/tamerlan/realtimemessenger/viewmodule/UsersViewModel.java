package com.tamerlan.realtimemessenger.viewmodule;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UsersViewModel extends ViewModel {

    private FirebaseAuth mAuth;
    public MutableLiveData<FirebaseUser> user = new MutableLiveData<>();
    public UsersViewModel() {
        mAuth = FirebaseAuth.getInstance();
        mAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    user.setValue(firebaseAuth.getCurrentUser());
            }
        });
    }

    public LiveData<FirebaseUser> getUser() {
        return user;
    }

    public void logout(){
        mAuth.signOut();
    }
}
