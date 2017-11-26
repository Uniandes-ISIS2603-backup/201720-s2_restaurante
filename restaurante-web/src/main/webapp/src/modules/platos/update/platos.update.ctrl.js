/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

       (function (ng) {
            var mod = ng.module("platoModule");
            mod.constant("platosContext", "http://localhost:8080/restaurante-web/api/platos");
            mod.controller('platoUpdateCtrl', ['$scope', '$http', 'platosContext', '$state','$rootScope', '$filter',
                function ($scope, $http, platosContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    var idPlato = $state.params.platoId;
                    
                    $http.get(platosContext + '/' + idPlato).then(function (response) {
                        var plato = response.data;
                        $scope.platoName= plato.name;
                        $scope.platoTipo= plato.tipo;
                        $scope.platoEspecialSucursal = plato.especialSucursal;
                        $scope.platoPrecio = plato.precio;
                     });

                    $scope.createCliente = function () {

                        $http.put(platosContext + "/" + idPlato, {
                            
                            id: idPlato,
                            name: $scope.platoName,
                            tipo: $scope.platoTipo,
                            especialSucursal: $scope.platoEspecialSucursal,
                            precio: $scope.platoPrecio
                            
                        }).then(function (response) {
                            
                    $state.go('platosList', {platoId: response.data.id}, {reload: true});
                         });

                        
                    };


                }
            ]);
        }
)(window.angular);


