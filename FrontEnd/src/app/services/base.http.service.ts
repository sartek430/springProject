import { throwError as observableThrowError, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ErrorWrapper } from '../model/errorWrapper';
import { environment } from 'src/environments/environment';

/**
 * Classe abstraite fournissant les fonctions de base pour les services HTTP (services récupérant les données depuis l'API)
 */
export abstract class BaseHttpService {
  /**
   * Constante donnant l'URL de base de l'API
   */
  protected readonly ApiBaseUrl: string = environment.baseUrl;
  protected readonly ApiWebservicesBaseUrl: string = environment.baseUrlWebservices;
  // protected readonly ApiBrokerBaseUrl: string = environment.baseUrlBroker;

  /**
   * Permet d'extraire les données JSON depuis une réponse serveur
   * @param res la réponse serveur
   */
  // tslint:disable-next-line:typedef
  protected extractData(res: object) {
    if (!res) {
      return null;
    }
    const body = res;
    return body || {};
  }

  /**
   * Permet d'extraire les détails d'une réponse serveur de type erreur
   * @param error la réponse serveur
   */
  // tslint:disable-next-line:typedef
  protected handleError(error: any) {
    const errorWrapper: ErrorWrapper = ErrorWrapper.FromResponse(error);
    return observableThrowError(errorWrapper);
  }

  /**
   * Permet de construire une URL en remplacent une clé par la valeur fournie.
   * @param url L'url dans laquelle rempacer la clé
   * @param paramKey le nom de la clé à remplacer. Elle doit être au foramt '{keyName}' où 'keyName' est le nom de la clé.
   * @param paramValue la valeur à insérer à la place de la clé
   */
  protected replaceUrlParam(
    url: string,
    paramKey: string,
    paramValue: string | number
  ): string {
    if (!url) {
      return null;
    }
    let paramValueAsString: string;
    if (paramValue === null) {
      paramValueAsString = null;
    } else if (typeof paramValue === 'string') {
      paramValueAsString = paramValue;
    } else {
      paramValueAsString = paramValue.toString();
    }
    return url.replace(
      '{' + paramKey + '}',
      encodeURIComponent(paramValueAsString)
    );
  }

  /**
   * Permet de construire une URL en remplacent une liste de couple clé/valeur.
   * Les clé de l'url doivent être au même format (ex: {keyName}) que pour la fonction replaceUrlParam.
   * @param url L'url dans laquelle rempacer les clés.
   * @param paramMap les couples clé/valeur sous la forme d'un tableau d'objets { key: "key", value: "value" }
   */
  protected replaceUrlParams(
    url: string,
    paramMap: { key: string; value: string | number }[]
  ): string {
    for (const paramItem of paramMap) {
      url = this.replaceUrlParam(url, paramItem.key, paramItem.value);
    }
    return url;
  }

  // tslint:disable-next-line:variable-name
  protected putString(
    // tslint:disable-next-line:variable-name
    _http: HttpClient,
    url: string,
    bodyData: string
  ): Observable<any> {
    return _http.put(url, JSON.stringify(bodyData));
  }

  /* protected getJsonContentTypeRequestOption() {
        const headers = new Headers({ 'Content-Type': 'application/json' });
        const options = new RequestOptions({ headers });
        return options;
    } */
}
