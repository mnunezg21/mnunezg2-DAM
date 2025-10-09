using UnityEngine;

public class EnemySpawn : MonoBehaviour
{
    private float elapsedTime = 0f;
    public GameObject gb;
    public Vector3 spawnPos = new Vector3(0,0,391.97f);
    public Vector3 spawnRot = new Vector3(0,180,0);
    public float intervalo = 2f;

    //Cada x segundos genera un nuevo coche con Instatiate
    void Update()
    {
        elapsedTime += Time.deltaTime;
        if (elapsedTime>=intervalo)
        {
            print("TIK");
            elapsedTime = 0;
            Quaternion rotation = Quaternion.Euler(spawnRot);
            Instantiate(gb, spawnPos, rotation);
           
        }
    }
}
