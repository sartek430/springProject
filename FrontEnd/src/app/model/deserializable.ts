declare var jQuery: any;
/**
 * Permet la conversion d'un objet json vers un modèle donné.
 */
export abstract class Deserializable<T> {
  protected static CreateFromJson<T>(type: new () => T, json: any): T {
    if (!json) {
      // console.warn('Deserializable : json null');
      return null;
    }
    const result = new type();
    jQuery.extend(result, json);

    // for (let propertyName in json) {
    //     if (json.hasOwnProperty(propertyName)) {
    //         let value = json[propertyName];
    //         if (typeof value === 'string') {
    //             let date = moment(value, "YYYY-MM-DDTHH:mm:ss");
    //             // console.log('property: ', propertyName, value, date.isValid());
    //         }
    //     }
    // }

    return result;
  }

  public abstract FromJson(json: any): T;

  public FromJsonList(jsonArray: any[]): T[] {
    if (!jsonArray || !Array.isArray(jsonArray)) {
      return [];
    }
    const result: T[] = jsonArray.map((jsonItem) => this.FromJson(jsonItem));
    return result;
  }

  // tslint:disable-next-line:typedef
  protected mapDate(jsonProperty: any) {
    if (!jsonProperty) {
      return null;
    }
    return new Date(jsonProperty);
  }
}
