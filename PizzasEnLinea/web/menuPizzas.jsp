<%-- 
    Document   : menuPizzas
    Created on : 26/06/2020, 11:52:22 AM
    Author     : leoba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Menú</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <script src="js/responsive-nav.js" type="text/javascript"></script>

    </head>

    <body>
        <div>
            <div>
                
                <header>
                   
                    <nav class="nav-collapse">
                         
                        <ul>
                            
                            <li class="menu-item active"><a href="#pizzas" data-scroll>Pizzas</a></li>
                            <li class="menu-item"><a href="#bebidas" data-scroll>Bebidas</a></li>
                            <li class="menu-item"><a href="#complementos" data-scroll>Complementos</a></li>
                            <li class="menu-item"><a href="#carrito" data-scroll>Carrito</a></li>
                            <li class="menu-item"><a href="#pagar" data-scroll>Pagar</a></li>
                            <!--<li class="salir"><a href="#menuPizzas.jsp" data-scroll>Salir</a></li>-->
                      </ul>
                    </nav>                                                                                  
                </header> 
                

                <section id="pizzas">
                    <h1>PIZZAS</h1>
                </section>

                <section id="bebidas">
                    <h1>BEBIDAS</h1>
                </section>

                <section id="complementos">
                    <h1>COMPLEMENTOS</h1>
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
