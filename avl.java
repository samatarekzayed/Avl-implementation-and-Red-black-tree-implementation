class avl {
    avlnode root;

    //////////////////////////////////////////////////////////
    int balanced(avlnode u) {
        if (u == null)
            return 0;

        return u.left.height - u.right.height;
    }

    ////////////////////////////////////////////////////////////
    avlnode search(avlnode root, int key)
    {




    }

    //////////////////////////////////////////////////////////////////
    int height(avlnode n)
    {
        if (n == null)
            return 0;
        return n.height;
    }
    ///////////////////////////////////////////////////////////////////
    avlnode rightRotate(avlnode n) {


    }

    /////////////////////////////////////////////////////////////
    avlnode leftRotate(avlnode n) {


    }

    ///////////////////////////////////////////////////////////////
    avlnode insert(avlnode n, int key) {



      return n;
    }
    ///////////////////////////////////////////////////////////////
    avlnode delete(avlnode root, int key){




        return root;
    }
    ///////////////////////////////////////////////////////////////
    int size(avlnode n)
    {

    }

    ///////////////////////////////////////////////////////////////////

}