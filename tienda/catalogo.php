<?php 
require_once "service/ProductoService.php";
$productoService = new ProductoService();
$productos = $productoService->getProductos();

$i = 0;
ob_start();
?>
<form action="carrito.php" method="GET">
<table border="1">
	<?php foreach($productos as $p):?>
		<tr>
			<td style="text-align:center;">
				<?=$p->producto?><br />
				<img style="width:200px;" src="<?=$p->imagen?>" alt="<?=$p->producto?>" /><br />
				<button name="producto" value="<?=$p->id?>">Agregar</button>
			</td>		
		</tr>
	<?php endforeach; ?>
	</table>
</form>
<?php 
$body = ob_get_contents();
ob_end_clean();
$titulo = "Catálogo de Productos";
include "includes/plantilla.php";
