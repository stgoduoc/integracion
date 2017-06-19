<?php

$wsdl 		= "http://localhost:8084/WebApplication1/UsuarioService?wsdl";
$cliente 	= new SoapClient( 
	$wsdl
	, array(
		"trace" => 1
		, "exception" => 0
		, "cache_wsdl" => WSDL_CACHE_NONE
	) 
);

var_dump($cliente->__getFunctions());
var_dump($cliente->__getTypes());

$resultado = $cliente->sumar(
	array(
		"uno" => "4",
		"dos" => "5"
	)
);

var_dump($resultado);

var_dump($cliente->hello(array("nombre"=>"Juan")));