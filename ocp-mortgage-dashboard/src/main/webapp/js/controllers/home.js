'use strict';

angular.module('app')
    .controller("HomeCtrl", ['$scope', '$http', 'Constants', function ($scope, $http, Constants) {

        $scope.consts = Constants;

        $http.get("service/home/processes").success(function (data) {
            console.log("Retrieved process data.");
            console.log(data);
            $scope.processes = data;
        });

        $http.get("service/home/running").success(function (data) {
            console.log("Retrieved instance data.");
            console.log(data);
            $scope.running = data;
        });

        $http.get("service/home/workitems").success(function (data) {
            console.log("Retrieved workitems.");
            console.log(data);
            $scope.workItems = data;
        });
    }]);
