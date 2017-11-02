/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(
        function (ng) {
            var mod = ng.module("clienteModule");
            mod.constant("clientesContext", "api/clientes");
            mod.constant("pedidosContext", "api/pedidos");
            mod.controller('clientesUpdateCtrl', ['$scope', '$http', 'clientesContext', '$state', 'pedidosContext', '$rootScope', '$filter',
                function ($scope, $http, clientesContext, $state, booksContext, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idCliente = $state.params.ClienteId;

                    // Este arreglo guardara los ids de los books asociados y por asociar al autor.
                    var idsPedidos = [];

                    // Este arreglo mostrará los books una vez esten filtrados visualmente por lo que el autor ya tiene asociado.
                    $scope.allPedidosShow = [];

                    //Consulto el autor a editar.
                    $http.get(clientesContext + '/' + idCliente).then(function (response) {
                        var cliente = response.data;
                        $scope.clienteName = cliente.name;
                        $scope.clienteBirthDate = new Date(cliente.birthDate);
                        $scope.clienteDescription = cliente.description;
                        $scope.clienteImage = cliente.image;
                        $scope.allBooksAuthor = cliente.books;
                        $scope.mergeBooks($scope.allBooksAuthor);
                    });

                    /*
                     * Esta función añade los ids de los books que ya tiene el autor asociado.
                     * @param {type} books: Son los books que ya tiene asociado el autor.
                     * @returns {undefined}
                     */
                    $scope.mergePedidos = function (pedidos) {
                        for (var item in pedidos) {
                            idsPedidos.push("" + pedidos[item].id);
                        }
                        $scope.getPedidos(pedidos);
                    };

                    /*
                     * Esta función recibe como param los books que tiene el autor para hacer un filtro visual con todos los books que existen.
                     * @param {type} books
                     * @returns {undefined}
                     */
                    $scope.getPedidos = function (pedidos) {
                        $http.get(pedidosContext).then(function (response) {
                            $scope.AllPedidos = response.data;
                            $scope.pedidosCliente = pedidos;

                            var filteredPedidos = $scope.AllPedidos.filter(function (AllPedidos) {
                                return $scope.pedidosCliente.filter(function (pedidosCliente) {
                                    return pedidosCliente.id == AllPedidos.id;
                                }).length == 0
                            });

                            $scope.allPedidosShow = filteredPedidos;

                        });
                    };


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
                        //Cuando un book se añade al autor, se almacena su id en el array idsBook
                        idsBook.push("" + data);
                    };

                    $scope.dropDelete = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                        //Para remover el cliente que no se va asociar, por eso se usa el splice que quita el id del book en el array idsBook
                        var index = idsBook.indexOf(data);
                        if (index > -1) {
                            idsBook.splice(index, 1);
                        }
                    };

                    $scope.createCliente = function () {
                        /*Se llama a la función newBooks() para buscar cada uno de los ids de los books
                         en el array que tiene todos los books y así saber como queda la lista final de los books asociados al autor.
                         */
                        $scope.newPedidos();
                        $http.put(pedidosContext + "/" + idCliente, {
                            name: $scope.clienteName,
                            birthDate: $scope.clienteBirthDate,
                            description: $scope.clienteDescription,
                            image: $scope.clienteImage
                        }).then(function (response) {
                            if (idsPedidos.length >= 0) {
                                $http.put(clientesContext + "/" + response.data.id + "/pedidos", $scope.allPedidosCliente).then(function (response) {
                                });
                            }
                            //Author created successfully
                            $state.go('clientesList', {clienteId: response.data.id}, {reload: true});
                        });
                    };

                    $scope.newPedidos = function () {
                        $scope.allPedidosCliente = [];
                        for (var ite in idsPedidos) {
                            for (var all in $scope.AllPedidos) {
                                if ($scope.AllPedidos[all].id === parseInt(idsPedidos[ite])) {
                                    $scope.allPedidosCliente.push($scope.AllPedidos[all]);
                                }
                            }
                        }
                    };
                }
            ]);
        }
)(window.angular);


