<?php
session_start();

require_once "service/ProductoService.php";
$productoService = new ProductoService();

if( isset($_GET["producto"]) ){
	$producto_id = intval($_GET["producto"]);
	$_SESSION["carrito"][$producto_id] = 1;
}

?>

<a href="catalogo.php">Seguir comprando</a>

<form action="salir.php">
	<button type="submit">Salir</button>
</form>

</body>
</html>