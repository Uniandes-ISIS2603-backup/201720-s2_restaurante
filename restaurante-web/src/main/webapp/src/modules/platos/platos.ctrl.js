/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function (ng) {
    var mod = ng.module("platoModule", ['ui.router']);
    mod.constant("platosContext", "http://localhost:8080/restaurante-web/api/platos");
    mod.controller('platosCtrl', ['$scope', '$http', 'platosContext','$state',
        function ($scope, $http, platosContext, $state) {
            $http.get(platosContext).then(function (response) {
                $scope.platosRecords = response.data;
            });

        if (($state.params.platosId !== undefined) && ($state.params.platosId !== null)) {
                $http.get(platosContext + '/' + $state.params.platosId).then(function (response) {
                    $scope.currentPlato = response.data;
                });
            }
        }
    ]);
}
)(window.angular);





















