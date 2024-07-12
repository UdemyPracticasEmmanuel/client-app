<h1>Springboot Client</h1>
<p>Cliente que se comunicará con servicio de autenticación de 'authserver'</p>
<h1>How it works</h1>
<ul>
  <li>Ejecutar 'AuthServerApplication.java' del proyecto https://github.com/UdemyPracticasEmmanuel/authserver.git, mediante el comando Run
  </li>
  <li>Ejecutar 'ClientAppApplication.java' de este proyecto, mediante Run</li>
  <li>Ir al navegador y teclear 'http://127.0.0.1:8080/oauth2/authorization/client-app', esto redireccionará al servidor de autenticación 'http://127.0.0.1:9000/login' <br>
  <img width="477" alt="img_1" src="https://github.com/UdemyPracticasEmmanuel/client-app/assets/170979954/68f9d1f0-57ce-42f2-9dac-254a04aeca70">
  </li>
  <li>Ingresar las credenciales usuario: 'admin', password: '12345' , el usuario será redirigido al siguiente endpoint que mostrará el token para ingresar desde Postman al pokemon deseado: <br>
  <img width="552" alt="token" src="https://github.com/UdemyPracticasEmmanuel/client-app/assets/170979954/685f339b-adba-4d91-8adb-2705e6edba6e">
    <br>
    <p>Este endpoint, utiliza un servicio a través de la URL http://127.0.0.1:9000/oauth2/token con POST y Authorization Type: 'Basic Auth', username 'client-app' y password '12345', con el cuál obtiene el 'access_token' anteriormente mostrado en pantalla, el cuál es necesario para solicitar a la API https://pokeapi.co/api/v2/pokemon/ los datos del pokemon 'ditto' (o cualquier otro).</p>
  </li>
  <li>A continuación abrir Postman y estblecer Authorization Type: 'Bearer Token' y colocar el token recién obtenido: <br>
    <img width="506" alt="pokemon_solicitado_con_token" src="https://github.com/UdemyPracticasEmmanuel/client-app/assets/170979954/3f41bd9f-017d-45b6-b1a3-d8d853ad6067"><br>
  </li>
  <li>
    Para probar la funcionalidad de Encriptado, en Postman mediante GET, sobre la misma ruta de /pokemon, setear: "/aes?message={El mensaje que queremos cifrar}", utilizando el token antes creado: <br>
    <img width="628" alt="encrypted_postman" src="https://github.com/user-attachments/assets/3b5851c0-e916-4fd2-b878-c4d02bc4cf21"><br>
  </li>
  Para las pruebas unitarias, utilizar las que se hallan creadas en "ClientAppApplicationTests.java".
</ul>
