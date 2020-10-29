package com.example.dream.data;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.dream.MainActivity;
import com.example.dream.data.model.LoggedInUser;
import com.example.dream.network.Login;
import com.example.dream.network.NetworkService;
import com.example.dream.network.Tokens;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        Login m = new Login();
        m.setEmail(username);
        m.setPassword(password);
        NetworkService.getInstance()
                .getJSONApi()
                .login(m)
                .enqueue(new Callback<Tokens>() {
                    @Override
                    public void onResponse(@NonNull Call<Tokens> call, @NonNull Response<Tokens> response) {


                        if (response.errorBody() == null && response.isSuccessful()) {
                            //passwordLayout.setError("");
                            //loginButton.setError("");
                            Tokens post = response.body();
                            // Toast toast = Toast.makeText(getApplicationContext(), "All done! your ref token :" + post.getRefreshToken(), Toast.LENGTH_LONG);
                            //toast.show();
                            //saveJWTToken(post.getToken(),post.getRefreshToken());
                            //CommonUtils.hideLoading();
                            //Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                            //startActivity(intent);
                        } else {
                            //emailLayout.setError("");
                            //password.setError("Login or password was wrong");
                            //CommonUtils.hideLoading();
                            //passwordLayout.setError("Login or password was wrong");
                            //loginButton.setError("Login or password was wrong");
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<Tokens> call, @NonNull Throwable t) {

                        //CommonUtils.hideLoading();
                        //textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });

        try {
            // TODO: handle loggedInUser authentication
            if(username.equals("Soso"))
            {
                LoggedInUser fakeUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                "Dream");
                return new Result.Success<>(fakeUser);
            }
            else
            {
                return new Result.Error(new IOException("Облом ..."));
            }

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}