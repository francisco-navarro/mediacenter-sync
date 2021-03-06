(function() {
  'use strict';

  angular
    .module('app.configuration')
    .directive('authBox', authBox);

  /* @ngInject */
  function authBox(AuthService, toastr) {
    return {
      restrict: 'E',
      replace: false,
      scope: {
        token: '='
      },
      transclude: true,
      templateUrl: 'app/configuration/auth/auth.box.template.html',
      link: linkFn
    };

    function linkFn(scope, element, attrs, controller, transcludeFn) {
      scope.login = function() {
        AuthService.login(scope.boxPassword)
          .then(function(response) {
            scope.token = response;
            scope.logged = true;
            toastr.info('Login sucessfull');
          }, function() {
            //Error
            scope.logged = false;
            toastr.error('Login error');
          });
      };
    }
  }
})();
