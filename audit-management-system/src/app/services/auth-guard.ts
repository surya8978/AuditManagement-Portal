import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { TokenStorageService } from './token-storage.service';


@Injectable()
export class AuthGuardService implements CanActivate {

    constructor(public token:TokenStorageService, public router: Router) { }

    canActivate(): boolean {
        if (!this.token.isUserLoggedIn()) {
            this.router.navigate(['login']);
            return false;
        }
        return true;
    }

}