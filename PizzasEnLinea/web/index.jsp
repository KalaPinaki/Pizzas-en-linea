<%--
index.jsp

EIF209 - Programación 4 – Proyecto #2
Junio 2020

Autores:
- 116630575 Dafhnne Alfaro
- 304950273 Leonardo Baldares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <script src="js/script.js" type="text/javascript" ></script>
        <title>Login</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="contents">
                <section id="Login">
                    <form class="formularioLogin">
                        <p style="text-align: center;">
                            <label>Username:&nbsp;</label> <br>
                            <input type="text" id="user" name="user" autofocus="autofocus" placeholder="(digite identificación)"/>
                        </p>
                        <p style="text-align: center;">
                            <label>Password:&nbsp;</label> <br>
                            <input type="password" id="pass" name="pass" placeholder="(digite la contraseña)"/> <br>
                            <input type="checkbox" onclick="showPassword('pass')"> Mostrar contraseña
                        </p>
                        <p style="text-align: center;">
                            <button type="button" id="boton" name="boton" value ="1" onclick="login()">Ingresar</button>
                        </p>

                        <p style="text-align: center;">
                            <a href="javascript:void(0);" id="olvido" onclick="olvidaContraseña()">¿olvidó su contraseña?</a> <br>
                            <label>¿Eres nuevo?</label> 
                            <a href="javascript:void(0);" id="registro" onclick="registrar()">Registrate aquí</a>
                        </p>                      
                    </form> 
                </section>

                <!-- The Modal -->
                <div id="cambiaPass" class="modal">

                    <!-- Modal content -->
                    <div class="modal-content">
                        <span class="menuCambiar">&times;</span>
                        <table id="tab">
                            <caption> Cambio de contraseña </caption>
                            <tr>
                                <td>Digite su número de cédula: </td>
                                <td><input id="cedula" type="text"></td>
                            </tr>
                            <tr>
                                <td>Digite la nueva contraseña: </td>
                                <td><input id="newPass" type="password"></td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                                <td>
                                    <input type="checkbox" onclick="showPassword('newPass')"> Mostrar contraseña
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">
                                    <button type="button" id="boton" name="boton" value="2" onclick="confirmarCambio()">Aceptar</button>
                                </td>
                                <td style="text-align: center;">
                                    <button  type="button" id="boton" name="boton" value="4" onclick="cancelar()">Cancelar</button>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>

                <div id="registrar" class="modal">

                    <!-- Modal content -->
                    <div class="modal-content">
                        <span class="menuRegistro">&times;</span>
                        <table id="tab">
                            <caption> Registrar Usuario </caption>
                            <tr>
                                <td>Nombre: </td>
                                <td><input id="nombre" type="text"></td>
                            </tr>
                            <tr>
                                <td>Apellidos: </td>
                                <td><input id="apellidos" type="text"></td>
                            </tr>
                            <tr>
                                <td>Cédula: </td>
                                <td><input id="ced" type="text"></td>
                            </tr>
                            <tr>
                                <td>Domicilio: </td>
                                <td><input id="direccion" type="text"></td>
                            </tr>
                            <tr>
                                <td>Contraseña: </td>
                                <td><input id="pass2" type="password"></td>
                            </tr>
                            <tr>
                                <td>Teléfono: </td>
                                <td><input id="telefono" type="text"></td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                                <td>
                                    <input type="checkbox" onclick="showPassword('pass2')"> Mostrar contraseña
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">
                                    <button type="button" id="boton" name="boton" value="3" onclick="confirmarRegistro()">Aceptar</button>
                                </td>
                                <td style="text-align: center;">
                                    <button  type="button" id="boton" name="boton" value="4" onclick="cancelar()">Cancelar</button>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
