using System;
using UnityEngine;

public class EnemigoControler : MonoBehaviour
{
    void Start()
    {
    }

    void Update()
    {
    }
    
    public float speed = 20f;
    private void FixedUpdate()
    {
        //Se moverá hacia el frente 
        //transform.Translate(0, 0, 1);
        transform.Translate(Vector3.forward*Time.deltaTime*speed); 
        
        
    }

    
}
