(function () {
    angular.module('boulimiqueLitteraire').
        controller('MainCtrl', ['$scope', '$location',
        function ($scope, $location) {

        $scope.isActive = function(link){
            if (link == "home" && $location.path() == "/")
                return true;
            else if (link == "book" && $location.path() == "/books")
                return true;
            else if (link == "recipe" && $location.path() == "/recipes")
                return true;
            else
                return false;
        }
    }]);
}());