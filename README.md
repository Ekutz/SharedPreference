# Properties
## File I/O를 활용한 Properties
#### Basic Declare
```
final String internalStroagePath = Context.getFilesDir().getAbsolutePath();
final String fileName = "저장하고자하는 파일이름.properties";
```

---
#### Input
```
// Properties 생성
Properties prop = new Properties();
// key값과 value값 추가
prop.put(key, value);
try {
  // FileOutputStream을 이용하여 internalStorePath+"/"+PROP_FILE 위치에 파일에 저장
  FileOutputStream fos = new FileOutputStream(internalStorePath+"/"+PROP_FILE);
  // fos에 prop 저장
  prop.store(fos, "코멘트테스트");
  // fos 닫기
  fos.close();
} catch(Exception e) {
    e.printStackTrace();
}
```

---
#### Output
```
// 빈 String 값 생성
String value = "";
// Properties 생성
Properties prop = new Properties();
try {
  // FileInputStream을 이용하여 internalStorePath+"/"+PROP_FILE 위치에 파일에 읽어오기
  FileInputStream fis = new FileInputStream(internalStorePath+"/"+PROP_FILE);
  // prop에 fis에서 읽어온 데이터 저장
  prop.load(fis);
  // fis 닫기
  fis.close();
} catch(Exception e) {
    e.printStackTrace();
}
// 반환할 String안에 prop중 key값의 이름을 가진 값을 넣기
value = prop.getProperty(key);
```

---

## SharedPreference를 이용한 Properties
#### Basic Declare
```
final String SHARED_FILE = "파일이름.prop";
```

---
#### Input
```
// 설정파일의 이름을 SHARED_FILE로 SharedPreference 생성
SharedPreferences sharedPref = getSharedPreferences(SHARED_FILE, Context.MODE_PRIVATE);
// Editor 생성
SharedPreferences.Editor editor = sharedPref.edit();
// 값 삽입
editor.putString("email", editMail.getText().toString());
editor.putBoolean("shuffle", swShuffle.isChecked());
// editor 승인
editor.commit();
```

---
#### Output
```
// 설정파일의 이름을 SHARED_FILE로 SharedPreference 생성
SharedPreferences sharedPref = getSharedPreferences(SHARED_FILE, Context.MODE_PRIVATE);
// sharedPref.get타입("key", Default값)
String email = sharedPref.getString("email", null);
Boolean shuffle = sharedPref.getBoolean("shuffle", false);
```

---
