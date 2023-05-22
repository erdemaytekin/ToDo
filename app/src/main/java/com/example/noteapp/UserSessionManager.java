package com.example.noteapp;





//Bu kod parçacığı, bir Android uygulaması için bir UserSessionManager sınıfı tanımlar.
   // Bu sınıf, kullanıcının oturum bilgilerini yönetmek için kullanılır. Sınıfın içinde SharedPreferences ve SharedPreferences.
  //  Editor nesneleri bulunur. Bu nesneler, uygulamanın paylaşılan tercihlerini okuma ve yazma işlemlerini gerçekleştirmek için kullanılır.

//UserSessionManager sınıfının içinde üç adet metod bulunur: saveUserId, getUserId ve logout. 
   // saveUserId metodu, kullanıcının ID’sini paylaşılan tercihlere kaydeder. getUserId metodu, 
//paylaşılan tercihlerden kullanıcının ID’sini alır ve döndürür. Eğer kullanıcı ID’si kaydedilmemişse, bu metod -1 değerini döndürür. 
  //  logout metodu ise paylaşılan tercihlerden kullanıcı ID’sini kaldırır.




import android.content.Context;
import android.content.SharedPreferences;

public class UserSessionManager {
    private static final String userID = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public UserSessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("USER_ID", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUserId(int userId) {
        editor.putInt("USER_ID", userId);
        editor.commit();
    }


    public int getUserId() {
        return sharedPreferences.getInt("USER_ID", -1); // -1: Varsayılan değer, kullanıcı ID'si kaydedilmemişse
    }


    public void logout() {
        editor.remove("USER_ID");
        editor.commit();
    }

}
