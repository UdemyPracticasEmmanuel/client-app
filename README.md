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
  <img width="477" alt="img_2" src="https://github.com/UdemyPracticasEmmanuel/client-app/assets/170979954/10555d4a-e63e-4319-8653-fcd0812f84f2">
  </li>
  <li>Con este código, se pueden hacer pruebas de seguridad en Postman con la url http://127.0.0.1:9000/oauth2/token con POST, y obtener el 'access_token' para poder acceder a otros endpoints:<br>
  <img width="752" alt="img_3_unmarked" src="https://github.com/UdemyPracticasEmmanuel/client-app/assets/170979954/55737ddb-fb64-43d4-8b71-626ee9ca1aa8"><br>
    <b>Nota: este token solo estará activo por 5 min</b>
  </li>
  <li>
    Hacer pruebas con el endpoint http://127.0.0.1:8080/list y GET seleccionando 'Bearer Token' y seteando el Token recién generado:<br>
    <img width="516" alt="img_4" src="https://github.com/UdemyPracticasEmmanuel/client-app/assets/170979954/f4a43451-2052-414c-b1a4-1456b5280845">
  </li>
  <li>
    Hacer mismos pasos para el endpoint http://127.0.0.1:8080/create con POST: <br>
    <img width="505" alt="img_5" src="https://github.com/UdemyPracticasEmmanuel/client-app/assets/170979954/8d1626ab-238c-4f94-b618-3b923b2a6381">
  </li>
</ul>
