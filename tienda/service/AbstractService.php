<?php

abstract class AbstractService{
	
	protected abstract function getWSDL();
	
	protected function getCliente(){
		$service = new SoapClient( $this->getWSDL() );
		return $service;
	}
	
	// convierte a un array si devuelve solo un elemento
	protected function preparaRetorno($resultado){
		$resultado = $resultado->return;
		if(!is_array($resultado)){
			$resultado = array($resultado);	
		}
		return $resultado;
	}
	
}
