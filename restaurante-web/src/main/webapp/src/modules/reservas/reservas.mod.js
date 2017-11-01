(function (ng){
    var mod = ng.module("reservaModule",['ui.router']);
    mod.constant("reservasContext", "api/reservas");
    mod.config(['$stateProvider','urlRouterProvider', function($stateProvider,$urlRouterProvider){
            var basePath='src/modules/reservas/';
            $urlRouterProvider.otherwise("/reservasList");
            
            $stateProvider.state('reservas', {
                url: '/reservas',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'reservas.list.html',
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('reservasList', {
                url: '/list',
                parent: 'reservas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'reservas.list.html'
                    }
                }
            }).state('reservaDetail', {
                url: '/{reservaId:int}/detail',
                parent: 'reservas',
                param: {
                    reservaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'reservas.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'reservas.detail.html',
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl'
                    }

                }

            });
    }])
})(window.angular);