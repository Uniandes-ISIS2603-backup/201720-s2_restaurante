/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(
        function (ng) {
            var mod = ng.module("pedidoModule");
            mod.constant("pedidosContext", "api/pedidos");
            mod.constant("pedidosContext", "api/pedidos");
            mod.controller('pedidoUpdateCtrl', ['$scope', '$http', 'pedidosContext', '$state','$rootScope', '$filter',
                function ($scope, $http, pedidosContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idPedido = $state.params.PedidoId;
                    $http.get(pedidosContext + '/' + idPedido).then(function (response) {
                        var pedido = response.data;
                        $scope.pedidoNombre = pedido.nombre;
                        $scope.pedidoApellido = pedido.apellido;
                        $scope.pedidoDireccion = pedido.direccion;
                        $scope.pedidoNumPuntos = pedido.numPutnos;
                    });


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
                        //Cuando un pedido se añade al pedido, se almacena su id en el array idsPedido
                        idPedido.push("" + data);
                    };

                    $scope.dropDelete = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                        //Para remover el pedido que no se va asociar, por eso se usa el splice que quita el id del pedido en el array idsPedido
                        var index = idPedido.indexOf(data);
                        if (index > -1) {
                            idPedido.splice(index, 1);
                        }
                    };

                    $scope.createPedido = function () {
                        /*Se llama a la función newPedido() para buscar cada uno de los ids de los pedidos
                         en el array que tiene todos los pedidos y así saber como queda la lista final de los pedidos asociados al pedido.
                         */
                        $scope.newPedido();
                        $http.put(pedidosContext + "/" + idPedido, {
                            nombre: $scope.pedidoNombre,
                            apellido: $scope.pedidoApellido,
                            direccion: $scope.pedidoDireccion,
                            numPuntos: $scope.pedidoNumPuntos
                        })
                        ;
                    };
                }
            ]);
        }
)(window.angular);

