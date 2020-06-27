<%-- 
    Document   : menuAdmin
    Created on : 26/06/2020, 07:13:09 PM
    Author     : leoba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Opciones de administrador</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!-- -->
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <script src="js/responsive-nav.js" type="text/javascript"></script>
        <script src="js/logOutScript.js" type="text/javascript"></script>
  
    </head>
    <body>
        <div id="wrapper">
            <div id="contents">
                <header>

                    <nav class="nav-collapse">

                        <ul>

                            <li class="menu-item active"><a href="#pizzas" data-scroll>Administrar <br> Pizzas</a></li>
                            <li class="menu-item"><a href="#extras" data-scroll>Administrar <br> Ingredientes</a></li>
                            <li class="menu-item"><a href="#complementos" data-scroll>Administrar <br> Complementos</a></li>
                            <li class="menu-item"><a href="#bebidas" data-scroll>Administrar <br> Bebidas</a></li>
                            <li class="menu-item"><a href="#carrito" data-scroll>Administrar <br> Ordenes</a></li>
                            <li class="menu-item"><a href="#pagar" data-scroll>Consultar <br> ordenes</a></li>
                            <li class="salir"><a style="float: right" href="javascript:void(0);" onclick="logOut()">Salir</a></li>
                        </ul>
                    </nav>                                                                                  
                </header> 
                
                
                
                <section id="pizzas">
                    <h1>PIZZAS</h1>
                    <table class="tablaPizzas">
                        <tbody id="tPizzas">

                        </tbody>
                    </table>
                </section>

                <section id="extras">
                    <h1>EXTRAS</h1>
                    <table class="tablaExtras">
                        <tbody id="tExtras">
                        </tbody>
                    </table>
                </section>

                <section id="complementos">
                    <h1>COMPLEMENTOS</h1>
                    <table class="tablaComplemento">
                        <tbody id="tComplementos">

                        </tbody>
                    </table>
                </section>

                <section id="bebidas">
                    <h1>BEBIDAS</h1>
                    <table class="tablaBebidas">
                        <tbody id="tBebidas">

                        </tbody>
                    </table>
                </section>

                <section id="carrito">
                    <h1>CARRITO</h1>
                </section>

                <section id="pagar">
                    <h1>PAGAR</h1>
                </section>

                <script src="js/fastclick.js" ></script>
                <script src="js/scroll.js" ></script>
                <script src="js/fixed-responsive-nav.js" ></script>

                
            </div>
        </div>
    </body>
</html>
