using System;
using UnityEngine;

public class SeguirJugador : MonoBehaviour
{
    public GameObject player;
    void Start()
    {
        
    }
    void Update()
    {
        transform.position = player.transform.position + new Vector3(0,5,-7);
    }

    private void FixedUpdate()
    {
        
    }
}
