/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("loginModule");
    mod.controller('logoutCtrl', ['$rootScope', '$state', function ($rootScope, $state) {
            if (sessionStorage.getItem("username")) {
                sessionStorage.clear();
            } else {
                $state.go('restaurantesList', {}, {reload: true});
            }
        }
    ]);
}
)(window.angular);
