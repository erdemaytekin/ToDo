# ToDo
Erdem Aytekin proje ödevi 203405020 


https://github.com/erdemaytekin/ToDo/assets/116784884/576bf4e3-432c-479a-b25d-e43be94b3eab


//Bir not ekleme uygulaması yaptım. Uygulamaya giriş yapmadan önce kayıt ol kısmından kayıt oluyoruz. Create User sınıfı sayesinde daha sonra //kayıt olduğumuz kullanıcı adı ve şifreyle uygulamaya giriş yapıyoruz. Bu kullanıcı adı ve şifre database kısmında karşılaştırılıyor. Daha //sorna uygulama içinde not ekle sınıfının sayesindne not ekleyebiliyoruz. Sonra bu notu silebiliyoruz. Eğer notu silmeden uygulamadan   //çıkarsak not aynı şekilde yerinede kalacak şekilde database'de ayarlanmıştır. En son çıkış yapınca tekrar kayıt ol veya 
// giriş sayfasına atamış oluyor. 

//Kullanıcı arayüzü bileşenleri (Button, EditText) tanımlanır ve ilgili görünümler ile ilişkilendirilir.
//  Submit (Gönder) düğmesi için bir OnClickListener oluşturulur. Bu düğmeye tıklandığında aşağıdaki adımlar gerçekleşir:
// a. Kullanıcının girdiği e-posta adresi ve şifre alınır.
// b. Girilen e-posta adresinin belirtilen bir regex (düzenli ifade) ile geçerli olup olmadığı kontrol edilir. E-posta adresi, "^(.+)@(.+)$" deseni ile eşleşmelidir.
//   c. Şifrenin uzunluğu kontrol edilir ve en az 7 karakterden oluşması gerektiği doğrulanır.
//  d. Eğer e-posta adresi ve şifre geçerli ise, dbHelper sınıfı kullanılarak yeni bir kullanıcı oluşturulur.
//  e. MainActivity'ye geçiş yapılır (Ana ekran).

// Mainactivity 
//Bu kod, bir Android uygulaması için MainActivity adlı bir sınıf tanımlar. 
   // Bu sınıf, bir AppCompatActivity’dir ve uygulamanın ana ekranını temsil eder. 
  //  onCreate yöntemi, kullanıcı arayüzünü oluşturur ve giriş ve kaydolma düğmelerine tıklama işleyicileri ekler.
   // Giriş düğmesine tıklanırsa, kullanıcının e-posta adresi ve şifresi doğrulanır.
 //   Eğer doğruysa, kullanıcı oturumu açılır ve ana sayfaya yönlendirilir. Aksi halde, bir hata mesajı görüntülenir. 
  //  Kaydolma düğmesine tıklanırsa, kullanıcı kaydolma sayfasına yönlendirilir. 
  //  onDestroy yöntemi, kullanıcı çıkış yapmış olur.
  // MainPage 
  // Projenin anasayfasıdır. Doğru bir şekilde kullanıcı adı ve şifre girildiğinde bu class'a yönlendirilir
  //Bu kod parçacığı, bir NewNote sınıfı tanımlar. 
   // Bu sınıf, AppCompatActivity sınıfından türetilmiştir ve bir Android aktivitesini temsil eder. Sınıfın içinde onCreate metodu bulunur.
    //Bu metod, aktivite oluşturulduğunda çağrılır.

//onCreate metodunun içinde, aktivitenin arayüzü R.layout.activity_new_note kaynağından yüklenir.
    //Daha sonra dbHelper ve UserSessionManager nesneleri oluşturulur. noteBody ve submit değişkenleri, arayüzdeki ilgili bileşenlere atanır.

//submit düğmesine bir OnClickListener atanır.
     //  Daha sonra MainPage aktivitesine geçiş yapılır ve mevcut aktivite sonlandırılır.
//NoteJava 
//Kurucu metod, Note nesnesini oluştururken notun başlığını ve içeriğini alır ve bu değerleri sınıfın ilgili değişkenlerine atar. 
  //  getNoteHead metodu, notun başlığını döndürür. getNoteBody metodu ise notun içeriğini döndürür.
  // NoteAdapter 
  //Bu kod, bir Android uygulaması için bir NoteAdapter sınıfı tanımlar. 
  //  Bu sınıf, bir RecyclerView için bir adaptördür ve notların bir listesini görüntüler. 
 //   onCreateViewHolder yöntemi, her bir not için bir görünüm oluşturur. 
  //  onBindViewHolder yöntemi, her bir notun başlığını ve içeriğini görünüme bağlar. 
//    getItemCount yöntemi, notların sayısını döndürür. Ayrıca, MyViewHolder adlı bir iç sınıf tanımlanmıştır.
    // Splasah ACtivity
    //SplashActivity sınıfı, AppCompatActivity sınıfını genişletir ve başlangıç ekranının davranışını kontrol eder.
//onCreate yöntemi, aktivite oluşturulduğunda çağrılır ve başlangıç ekranının görünümünü yapılandırır.
//setContentView(R.layout.activity_splash) yöntemi, activity_splash.xml adlı bir düzen dosyasını kullanarak aktivitenin arayüzünü ayarlar. Bu //dosya, başlangıç ekranının görünen bileşenlerini içerir.
//getSupportActionBar().hide() yöntemi, etkinliğin varsayılan eylem çubuğunu gizler. Bu, başlangıç ekranında bir eylem çubuğu göstermek //istemediğimizi belirtir.
//Bir Intent nesnesi oluşturarak MainActivity sınıfına geçiş yapacağız. Intent sınıfı, farklı bileşenler arasında etkileşim sağlamak için //kullanılır.
//new Handler().postDelayed(...) ifadesi, belirtilen süre (ms cinsinden) sonunda bir işlemi gerçekleştirmek için bir zamanlayıcı oluşturur. Bu //durumda, 2000ms (2 saniye) sonra belirtilen işlem çalışacak.
//run() yöntemi, zamanlayıcı süresi dolduğunda çalıştırılacak işlemi içerir. Bu yöntemde, oluşturduğumuz Intent nesnesini kullanarak //MainActivity'e geçiş yaparız.
//startActivity(i) yöntemi, belirtilen Intent nesnesiyle yeni bir etkinlik başlatır. Bu, kullanıcıyı ana etkinliğe yönlendirir.
//finish() yöntemi, SplashActivity'i kapatır. Bu, kullanıcı ana etkinliğe geçtiğinde geri dönüşte başlangıç ekranının tekrar gösterilmemesini sağlar.
//Bu kod parçası, başlangıç ekranının 2 saniye boyunca görüntülenmesini sağlayarak kullanıcıya kısa bir bekleme süresi sunar ve ardından //MainActivity'e geçiş yapar.


//UserSessionManager
//Bu kod parçacığı, bir Android uygulaması için bir UserSessionManager sınıfı tanımlar.
   // Bu sınıf, kullanıcının oturum bilgilerini yönetmek için kullanılır. Sınıfın içinde SharedPreferences ve SharedPreferences.
  //  Editor nesneleri bulunur. Bu nesneler, uygulamanın paylaşılan tercihlerini okuma ve yazma işlemlerini gerçekleştirmek için kullanılır.

//UserSessionManager sınıfının içinde üç adet metod bulunur: saveUserId, getUserId ve logout. 
   // saveUserId metodu, kullanıcının ID’sini paylaşılan tercihlere kaydeder. getUserId metodu, 
//paylaşılan tercihlerden kullanıcının ID’sini alır ve döndürür. Eğer kullanıcı ID’si kaydedilmemişse, bu metod -1 değerini döndürür. 
  //  logout metodu ise paylaşılan tercihlerden kullanıcı ID’sini kaldırır.
  
  //dbHelper
  /*dbHelper sınıfı, SQLiteOpenHelper sınıfından türetilmiştir.
DATABASE_NAME ve DATABASE_VERSION sabitleri, veritabanının adını ve sürüm numarasını belirtir.
TABLE_USERS ve TABLE_NOTES sabitleri, kullanıcılar ve notlar için tablo isimlerini içerir.
Tablo sütunları için sabitler: COLUMN_USER_ID, COLUMN_USERNAME, COLUMN_PASSWORD, COLUMN_NOTE_ID, COLUMN_NOTE_HEAD, COLUMN_NOTE_BODY ve COLUMN_USER_ID_FK sütunlarını temsil eder.
dbHelper constructor'ı, veritabanı adını ve sürüm numarasını alır.
onCreate yöntemi, veritabanı oluşturulduğunda çağrılır ve kullanıcılar ve notlar tablolarını oluşturur.
onUpgrade yöntemi, veritabanı sürümü değiştiğinde çağrılır. Mevcut tabloları siler ve onCreate yöntemini çağırarak tabloları yeniden oluşturur.
createUser yöntemi, yeni bir kullanıcı ekler. Veritabanına kullanıcı adı ve parolayı kaydeder.
isUserValid yöntemi, verilen kullanıcı adı ve parolayı kontrol eder ve kullanıcının geçerli olup olmadığını kontrol eder.
getNotesByUserId yöntemi, belirli bir kullanıcıya ait notları getirir. Kullanıcı kimliği kullanılarak notları sorgular ve bir Note listesi döndürür.
getUserIdFromUsername yöntemi, kullanıcı adına göre kullanıcı kimliğini alır.
addNote yöntemi, yeni bir not ekler. Not başlığı, içeriği ve kullanıcı kimliğiyle birlikte bir not kaydeder.
getNoteId yöntemi, verilen başlıkla eşleşen not kimliğini alır.
deleteTitle yöntemi, verilen bir not kimliğine göre notu siler.
Bu kod parçası, kullanıcılar ve notlar için ayrı tablolar kullanan bir SQLite veritabanı yapısını temsil eder. dbHelper sınıfı, veritabanı işlemlerini gerçekleştirmek için gerekli yöntemleri sağlar */

