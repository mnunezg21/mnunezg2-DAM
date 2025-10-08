using UnityEngine;

public class EnemySpawn : MonoBehaviour
{
    private float elapsedTime = 0;
    public GameObject gb;
    void Start()
    {
        
    }

    //Cada x segundos genera un nuevo coche con Instatiate
    void Update()
    {
        elapsedTime += Time.deltaTime;
        if (elapsedTime>=1)
        {
            
            print("TIK");
            elapsedTime = 0;
            gb.
        }
    }
}
