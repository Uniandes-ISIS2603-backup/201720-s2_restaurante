/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("platoModule");//Definicion del modulo que usaremos desde el app.js
    mod.constant("platosContext", "http://localhost:8080/restaurante-web/api/platos");
    mod.controller('platosCtrl', ['$scope', '$http', 'platosContext','$state',
        /*
         * Informacion del plato obtenida desde el api de platos para representarla en los records del modulo
         */
        function ($scope, $http, platosContext, $state) {
            $http.get(platosContext).then(function (response) {
                $scope.platosRecords = response.data;
            });
        
            /*
            * Manejo del plato con un id especificado por parametro
            * Param: platoId
            */    
        if (($state.params.platoId !== undefined) && ($state.params.platoId !== null)) {
                $http.get(platosContext + '/' + $state.params.platoId).then(function (response) {
                    $scope.currentPlato = response.data;
                });
            }
        }
    ]);
}
)(window.angular);





















