/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("platoModule");
    mod.constant("platosContext", "api/platos");
    mod.controller('platoDeleteCtrl', ['$scope', '$http', 'platosContext', '$state',
        function ($scope, $http, platosContext, $state) {
            var idPlato = $state.params.platoId;
            $scope.deletePlato = function () {
                $http.delete(platosContext + '/' + idPlato, {}).then(function (response) {
                    $state.go('platosList', {platoId: response.data.id}, {reload: true});
                    var index = $scope.platosRecords.indexOf(response.data);
                    $scope.platosRecords.splice(index, 1);
                });
            };
        }
    ]);
}
)(window.angular);

