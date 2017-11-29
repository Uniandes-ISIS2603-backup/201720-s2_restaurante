(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
        // Internal modules dependencies
        'clienteModule',
        'restauranteModule',
        'domicilioModule',
        'reservaModule',
        'loginModule',
        'platoModule'
    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
    
    //Parte del run para el login y el logout
    app.run(['$rootScope', '$transitions', function ($rootScope, $transitions) {

            $transitions.onSuccess({to: '*'}, function (trans) {

                var $state = trans.router.stateService;
                //Inicamos la variable en false
                var requireLogin = false;
                
                //verificamos que el token del login este no definido, en ese caso requerimos login
                if(sessionStorage.token !== undefined)
                {
                    requireLogin = true;
                }
                var roles = [sessionStorage.rol];

                /*
                 * El usuario esta identificado?
                 */
                $rootScope.isAuthenticated = function () {

                    if (sessionStorage.getItem("username") != null) {
                        $rootScope.currentUser = sessionStorage.getItem("name");
                        return true;
                    } else {
                        return false;
                    }
                };
                /*
                 * El usuario iene permisos para realizar x accion?
                 */
                $rootScope.hasPermissions = function () {
                    if (($rootScope.isAuthenticated) && (roles.indexOf(sessionStorage.getItem("rol")) > -1) && sessionStorage.rol === 'admin') {
                        return true;
                    } else {
                        return false;
                    }
                };


                if (requireLogin && (sessionStorage.getItem("username") === null)) {
                    event.preventDefault();
                    $state.go('login', $state.params);
                }

            });

        }]);
})(window.angular);
