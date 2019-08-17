<h2> Application under development </h2>
<br>
<h2>Rest api for calculating individual nutritional requirements.</h2>
<h3>
  Used technologies:
  <ul>
    <li>Java 11</li>
    <li>Spring boot</li>
    <li>Maven</li>
    <li>Spock</li>
    <li>PostgreSQL</li>
    <li>Angular</li>
    <li>Kafka</li>
    <li>Lombok</li>
    <li>Flyway</li>
    <li>Orika</li>
    <li>Bootstrap</li>
    <li>Thymeleaf</li>
    <li>Greenmail</li>
  </ul>
</h3>
<br>
<h3>
  Functionalities:
  <ul>
    <li>User login/registration</li>
    <li>Measurements tracking</li>
    <li>Obtaining individual requirements</li>
    <li>Creating kafka events</li>
    <li>Sending emails based on kafka events</li>
  </ul>
</h3>
<br>
<h4> How to run the application:<h4>
  <p><b>1) Install jdk 11, maven, postgres 9.6</b></p>
  <p><b>2) Setup postgres connection and create database called nutritional_requirements (you can use DBeaver or other tool)</b></p>
  <p><b>3)Set your database details in environmental variables:</b></p>
  <p>CALCULATOR_DATABASE_URL for example jdbc:postgresql://localhost:5432/nutritional_requirements</p>
  <p>CALCULATOR_DATABASE_USERNAME for example postgres</p>
  <p>CALCULATOR_DATABASE_PASSWORD for example postgres</p>
  <p><b>4)Set your email account details in environmental variables:</b></p>
  <p>CALCULATOR_MAIL_HOST for example smtp.gmail.com</p>
  <p>CALCULATOR_MAIL_USERNAME for example test.account@gmail.com</p>
  <p>CALCULATOR_MAIL_PASSWORD for example password</p>
  <p><b>5)Download project and run it from command line or IDE</b></p>
  
  
  
  
  
