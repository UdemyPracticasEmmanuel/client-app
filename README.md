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
  <li>Con este código, se pueden hacer pruebas de seguridad en Postman con la url http://127.0.0.1:9000/oauth2/token mediante POST, estableciendo Authorization Type: 'Basic Auth', con username 'client-app' y password '12345' <br>
    <img width="802" alt="img_7" src="https://github.com/UdemyPracticasEmmanuel/client-app/assets/170979954/947c3009-7220-4f52-9d1b-7e3b167edc91"><br>
    y así obtener el 'access_token' para poder acceder a otros endpoints:<br>
  <img width="752" alt="img_3_unmarked" src="https://github.com/UdemyPracticasEmmanuel/client-app/assets/170979954/55737ddb-fb64-43d4-8b71-626ee9ca1aa8"><br>
    <b>Nota: este token solo estará activo por 5 min</b>
  </li>
  <li>
    Hacer pruebas con el endpoint http://127.0.0.1:8080/pokemon/ditto (o cualquiera de los pokemon de 1era generación: bulbasaur, charmander, etc.) y GET seleccionando 'Bearer Token' y seteando el Token recién generado:<br>
    <img width="721" alt="img_6" src="https://github.com/UdemyPracticasEmmanuel/client-app/assets/170979954/5e244b4d-9f09-4c3e-96c3-544d2d747d45">

  </li>
</ul>
