<?php

//$wsdl   = "file:///var/www/html/EmpleadoService.wsdl";
$wsdl = "http://127.0.0.1:8280/services/EmpleadoService?wsdl";

$cliente = new SoapClient(
                $wsdl
                , array(
                    "trace"         => 1
                    , "exception"   => true
                    //, "cache_wsdl"  => WSDL_CACHE_NONE
                    , "cache_wsdl"  => WSDL_CACHE_MEMORY
                ) 
            );

$cliente->crear(
    array(
        "nombre"    => "Raul Jaramillo"
        ,"edad"     => 32
    )
);

$empleados = $cliente->getEmpleados();
$empleados = $empleados->return;
?>

<table border="1">
    <tr style="background: #ccc;">
        <th>Nombre</th>
        <th>Edad</th>
    </tr>
<?php foreach($empleados as $e): ?>
    <tr>
        <td>
        <?=$e->nombre ?>
        </td>
        <td>
        <?=$e->edad ?>
        </td>
    </tr>
<?php endforeach ?>
</table>



