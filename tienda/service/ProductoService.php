<?php 
require_once "AbstractService.php";
require_once "config.php";

class ProductoService extends AbstractService{
	
	protected function getWSDL(){
		return Config::PRODUCTO_SERVICE_WSDL;		
	}
	
	public function getProductos(){
		$cliente = $this->getCliente();
		$productos = $cliente->getProductos();
		return self::preparaRetorno($productos);
	}
	
	public function getProductoById($id){
		$cliente 	= $this->getCliente();
		$producto 	= $cliente->getProductoById($id);
		return $producto->return;
	}
	
}