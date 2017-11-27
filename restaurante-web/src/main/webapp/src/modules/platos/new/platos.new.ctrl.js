/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("platoModule");//Definicion del modulo que usaremos desde el app.js
    mod.constant("platosContext", "http://localhost:8080/restaurante-web/api/platos");
    mod.controller('platoNewCtrl', ['$scope', '$http', 'platosContext', '$state', '$rootScope',
        function ($scope, $http, platosContext, $state, $rootScope) {
            $rootScope.edit = false;
            /*
             * Funcion para crear un nuevo plato a partir de los parametros definidos en el back
             */
            $scope.createPlato = function () {
                $http.post(platosContext, {
                    name: $scope.platoName,
                    especialSucursal: $scope.platoEspecialSucursal,
                    precio: $scope.platoPrecio,
                    image: $scope.platoImage
                }).then(function (response) {
                    //platos created successfully
                    $state.go('platosList', {platoId: response.data.id}, {reload: true});
                    var index = $scope.platosRecords.indexOf(response.data);
                    $scope.platosRecords.splice(index, 1);
                });
            };
        }
    ]);
}
)(window.angular);

