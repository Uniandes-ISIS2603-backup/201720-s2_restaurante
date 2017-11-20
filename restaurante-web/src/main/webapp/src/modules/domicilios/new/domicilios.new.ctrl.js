/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("domicilioModule");
    mod.constant("domiciliosContext", "api/domicilios");
    mod.controller('domicilioNewCtrl', ['$scope', '$http', 'domiciliosContext', '$state', 'domiciliosContext', '$rootScope',
        function ($scope, $http, domiciliosContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createdomicilio = function () {
                $http.post(domiciliosContext, {
                }).then(function (response) {
                    //restaurante created successfully
                    $state.go('domiciliosList', {domicilioId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);