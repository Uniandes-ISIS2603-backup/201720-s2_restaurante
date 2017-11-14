/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("domicilioModule");
    mod.constant("domicilliosContext", "api/domicilios");
    mod.controller('domicilioDeleteCtrl', ['$scope', '$http', 'domiciliosContext', '$state',
        function ($scope, $http, domiciliosContext, $state) {
            $scope.deleteReDomicilio = function () {
                $http.delete(domiciliosContext + '/' + idDomicilio, {}).then(function (response) {
                    $state.go('domiciliosList', {domicilioId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);