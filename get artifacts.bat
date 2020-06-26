wsimport -d generated -extension -keep -p PizzaEnLinea.modelo.orden -Xnocompile -XadditionalHeaders http://localhost:8084/pizzasEnLinea_WS_/ServicioOrden?wsdl
wsimport -d generated -extension -keep -p PizzaEnLinea.modelo.pago -Xnocompile -XadditionalHeaders http://localhost:8084/pizzasEnLinea_WS_/ServicioPago?wsdl
wsimport -d generated -extension -keep -p PizzaEnLinea.modelo.pizza -Xnocompile -XadditionalHeaders http://localhost:8084/pizzasEnLinea_WS_/ServicioPizza?wsdl
wsimport -d generated -extension -keep -p PizzaEnLinea.modelo.usuario -Xnocompile -XadditionalHeaders http://localhost:8084/pizzasEnLinea_WS_/ServicioUsuario?wsdl
wsimport -d generated -extension -keep -p PizzaEnLinea.modelo.complemento -Xnocompile -XadditionalHeaders http://localhost:8084/pizzasEnLinea_WS_/ServicioComplemento?wsdl
wsimport -d generated -extension -keep -p PizzaEnLinea.modelo.ingrediente -Xnocompile -XadditionalHeaders http://localhost:8084/pizzasEnLinea_WS_/ServicioIngredientes?wsdl
wsimport -d generated -extension -keep -p PizzaEnLinea.modelo.bebida -Xnocompile -XadditionalHeaders http://localhost:8084/pizzasEnLinea_WS_/ServicioBebidas?wsdl
