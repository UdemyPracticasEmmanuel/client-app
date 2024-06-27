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
  <li>Ingresar las credenciales usuario: 'admin', password: '12345' , el usuario será redirigido al siguiente endpoint: <br>
  <img width="477" alt="img_8" src="https://github.com/UdemyPracticasEmmanuel/client-app/assets/170979954/002ddf78-ba19-4b15-af52-e5b0683005f1"><br>
  </li>
El cual mediante un servicio utiliza la URL http://127.0.0.1:9000/oauth2/token mediante POST, establece Authorization Type: 'Basic Auth', con username 'client-app' y password '12345', obtiene el 'access_token' necesario para solicitar a la API https://pokeapi.co/api/v2/pokemon/ los datos del pokemon 'ditto' y devuelve el resultado en pantalla en formato JSON.
</ul>
