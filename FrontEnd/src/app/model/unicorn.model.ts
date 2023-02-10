import { Deserializable } from './deserializable';

export class Unicorn extends Deserializable<Unicorn> {
    // Attributs
    public type: number;
    public name: string;
    public color: string;
    public price: number;
    public horn_size :number;
    public description :string;
    public max_speed :number;
    public spell :string;
    public power :number;

    /**
     * Désérialiser un objet json passé en paramètre
     * @param json Objet de type json
     * @returns un objet de type ServiceEAI
     */
    public FromJson(json: any): Unicorn {
        const model: Unicorn = Deserializable.CreateFromJson(Unicorn, json);
        if (null == model) {
            return null;
        }

        return model;
    }

}
