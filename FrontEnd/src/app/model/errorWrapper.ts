import { Deserializable } from './deserializable';

/**
 * Modèle renvoyé par le serveur lorsqu'une erreur apparaît
 */
export class ErrorWrapper extends Deserializable<ErrorWrapper> {

    /// --- Properties
    public ErrorMessage: string;
    public ErrorDetails: string;
    public Type: string;
    public StackTrace: string;

    /// --- Static Methods
    /**
     * Instancie un objet ErrorWrapper depuis une réponse HTTP
     * @param response la réponse HTTP depuis laquelle récupérer les informations de l'erreur
     */
    public static FromResponse(response: any): ErrorWrapper {
        let errorWrapper = new ErrorWrapper();
        const body = response.json();
        if ( 404 === response.status ) { // 404 Error
            errorWrapper.ErrorMessage = body.Message;
            errorWrapper.ErrorDetails = body.MessageDetail;
            errorWrapper.Type = '404';
        } else if (!!body.ErrorMessage) { // Body is an ErrorWrapper
            errorWrapper = new ErrorWrapper().FromJson(body);
        } else { // Fallback
            errorWrapper.ErrorMessage = body.Message || 'Erreur inconnue. Le serveur est probablement inaccessible...';
            errorWrapper.Type = 'unknown';
        }
        return errorWrapper;
    }
    /**
     * Instancie un objet ErrorWrapper depuis une chaîne de caractères
     * @param theErrorMessage le message d'erreur que doit contenir l'objet ErrorWrapper
     * @param isBusiness [Optinnel] indique que le message d'erreur est de type metier
     */
    public static CreateFromString(theErrorMessage: string, isBusiness: boolean = false): ErrorWrapper {
        return new ErrorWrapper().FromJson(
            {
                ErrorMessage: theErrorMessage,
                Type: 'CreateFromString' + (isBusiness ? '.Business' : '')
            } as ErrorWrapper
        );
    }

    /// --- Methods
    public override toString(): string {
        let message: string = !this.ErrorMessage ? 'Erreur inconnue' : this.ErrorMessage;
        if (null != this.ErrorDetails) {
            message += '\nDetails : ' + this.ErrorDetails;
        }
        return message;
    }
    public FromJson(json: any): ErrorWrapper {
        const model: ErrorWrapper = Deserializable.CreateFromJson(ErrorWrapper, json);
        return model;
    }

}
