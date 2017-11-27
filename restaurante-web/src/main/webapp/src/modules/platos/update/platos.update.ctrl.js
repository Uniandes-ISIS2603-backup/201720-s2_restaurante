/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
            var mod = ng.module("platoModule");//Definicion del modulo que usaremos desde el app.js
            mod.constant("platosContext", "http://localhost:8080/restaurante-web/api/platos");
            mod.controller('platoUpdateCtrl', ['$scope', '$http', 'platosContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, platosContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    var idplato = $state.params.platoId;//id que usaremos para especificar un plato, viene de un parametro                  

                    //Consulto el plato a editar.
                    $http.get(platosContext + '/' + idplato).then(function (response) {
                        var plato = response.data;
                        $scope.platoName = plato.name;
                        $scope.platoEspecialSucursal = plato.especialSucursal;
                        $scope.platoPrecio = plato.precio;
                        
                    });

                    //scroll html5
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
                        
                    };
                    
                    $scope.createPlato = function () {
                        
                        $http.put(platosContext + "/" + idplato, {
                            
                            name: $scope.platoName,
                            especialSucursal: $scope.platoEspecialSucursal,
                            precio: $scope.platoPrecio
                            
                        }).then(function (response) {
                    //Plato created successfully
                    $state.go('platosList', {platoId: response.data.id}, {reload: true});
                });
                    };

                }
            ]);
        }
)(window.angular);


