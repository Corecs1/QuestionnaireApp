declare var M:any
import {Injectable} from "@angular/core";

@Injectable()
export class MaterialService {
  static toast(message: string) {
    M.toast({html: message})
  }
}
