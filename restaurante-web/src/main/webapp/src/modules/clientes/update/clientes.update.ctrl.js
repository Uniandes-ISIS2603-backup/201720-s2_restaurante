/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(
        function (ng) {
            var mod = ng.module("clienteModule");
            mod.constant("clientesContext", "http://localhost:8080/restaurante-web/api/clientes");
            mod.constant("pedidosContext", "http://localhost:8080/restaurante-web/api/clientes");
            mod.controller('clienteUpdateCtrl', ['$scope', '$http', 'clientesContext', '$state','$rootScope', '$filter',
                function ($scope, $http, clientesContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    var idCliente = $state.params.clienteId;

                    // Este arreglo guardara los ids de los clientes asociados y por asociar al autor.
//                    var idsPedidos = [];

                    // Este arreglo mostrará los clientes una vez esten filtrados visualmente por lo que el autor ya tiene asociado.
//                    $scope.allPedidosShow = [];

                    //Consulto el autor a editar.
                    $http.get(clientesContext + '/' + idCliente).then(function (response) {
                        var cliente = response.data;
                        $scope.clienteNombre = cliente.nombre;
                        $scope.clienteApellido = cliente.apellido;
                        $scope.clienteDireccion = cliente.direccion;
                        $scope.clienteNumPuntos = cliente.numPutnos;
//                        $scope.allPedidosCliente = cliente.pedidos;
//                        $scope.mergeBooks($scope.allPedidosCliente);
                    });
//
//                    /*
//                     * Esta función añade los ids de los clientes que ya tiene el autor asociado.
//                     * @param {type} clientes: Son los clientes que ya tiene asociado el autor.
//                     * @returns {undefined}
//                     */
//                    $scope.mergePedidos = function (pedidos) {
//                        for (var item in pedidos) {
//                            idsPedidos.push("" + pedidos[item].id);
//                        }
//                        $scope.getPedidos(pedidos);
//                    };
//
//                    /*
//                     * Esta función recibe como param los clientes que tiene el autor para hacer un filtro visual con todos los clientes que existen.
//                     * @param {type} clientes
//                     * @returns {undefined}
//                     */
//                    $scope.getPedidos = function (pedidos) {
//                        $http.get(pedidosContext).then(function (response) {
//                            $scope.AllPedidos = response.data;
//                            $scope.pedidosCliente = pedidos;
//
//                            var filteredPedidos = $scope.AllPedidos.filter(function (AllPedidos) {
//                                return $scope.pedidosCliente.filter(function (pedidosCliente) {
//                                    return pedidosCliente.id == AllPedidos.id;
//                                }).length == 0
//                            });
//
//                            $scope.allPedidosShow = filteredPedidos;
//
//                        });
//                    };


                    //funciones para el drag and drop de HTML5 nativo
                    $scope.allowDrop = function (ev) {
                        ev.preventDefault();
                    };

                    $scope.drag = function (ev) {
                        ev.dataTransfer.setData("text", ev.target.id);
                    };

                    $scope.dropAdd = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                        //Cuando un pedido se añade al cliente, se almacena su id en el array idsPedido
                        idCliente.push("" + data);
                    };

                    $scope.dropDelete = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                        //Para remover el cliente que no se va asociar, por eso se usa el splice que quita el id del pedido en el array idsPedido
                        var index = idCliente.indexOf(data);
                        if (index > -1) {
                            idCliente.splice(index, 1);
                        }
                    };

                    $scope.createCliente = function () {
                        /*Se llama a la función newPedido() para buscar cada uno de los ids de los pedidos
                         en el array que tiene todos los pedidos y así saber como queda la lista final de los pedidos asociados al cliente.
                         */
//                        $scope.newCliente();
                        $http.put(clientesContext + "/" + idCliente, {
                            nombre: $scope.clienteNombre,
                            apellido: $scope.clienteApellido,
                            direccion: $scope.clienteDireccion,
                            numPuntos: $scope.clienteNumPuntos
                        }).then(function (response) {
                    //restaurante created successfully
                    $state.go('clientesList', {restauranteId: response.data.id}, {reload: true});
                });
//                                .then(function (response) {
//                            if (idsCliente.length >= 0) {
//                                $http.put(clientesContext + "/" + response.data.id + "/clientes", $scope.allPedidosCliente).then(function (response) {
//                                });
//                            }
//                            //Author created successfully
//                            $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
//                        })
                        ;
                    };

//                    $scope.newCliente = function () {
//                        $scope.allPedidosCliente = [];
//                        for (var ite in idsPedidos) {
//                            for (var all in $scope.AllPedidos) {
//                                if ($scope.AllPedidos[all].id === parseInt(idsPedidos[ite])) {
//                                    $scope.allPedidosCliente.push($scope.AllPedidos[all]);
//                                }
//                            }
//                        }
//                    };
                }
            ]);
        }
)(window.angular);


