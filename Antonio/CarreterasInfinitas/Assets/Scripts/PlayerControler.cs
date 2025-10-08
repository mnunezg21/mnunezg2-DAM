using System;
using UnityEngine;
using UnityEngine.InputSystem;

public class PlayerControler : MonoBehaviour
{
    public float speed = 5f;
    private Rigidbody rb;
    
    public InputActionAsset actionAsset;
    private InputAction moveAction;
    private Vector2 movVector;
    

    private void OnEnable()
    {
        actionAsset.FindActionMap("Player").Enable();
    }
    private void OnDisable()
    {
        actionAsset.FindActionMap("Player").Disable();
    }
    private void Awake()
    {
        moveAction = InputSystem.actions.FindAction("Move");
        rb = GetComponent<Rigidbody>();
    }

    void Update()
    {
        movVector = moveAction.ReadValue<Vector2>();
        rb.MovePosition(rb.position+transform.forward*speed*Time.deltaTime);
    }

    private void FixedUpdate()
    {
        rb.MovePosition(rb.position+transform.forward*20f*Time.deltaTime*movVector.y);
        //Movimiento lateral
        //rb.MovePosition(rb.position+transform.forward*10f*Time.deltaTime*movVector.x);
        
        //Rotacion
        Quaternion deltaRotation=
            Quaternion.Euler(new Vector3(0,movVector.x *100f*Time.deltaTime));
        rb.MoveRotation(rb.rotation*deltaRotation);
    }

    private void OnJump()
    {
        print("SALTA");
        rb.AddForce(Vector3.up*500f,ForceMode.Impulse);
    }

    private void OnCrecer()
    { 
        transform.localScale+=new Vector3(0.1f,0.1f,0.1f);
    }
}
