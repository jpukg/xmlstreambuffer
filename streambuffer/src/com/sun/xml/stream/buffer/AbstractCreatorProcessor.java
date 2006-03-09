/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 * 
 * You can obtain a copy of the license at
 * https://jwsdp.dev.java.net/CDDLv1.0.html
 * See the License for the specific language governing
 * permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * https://jwsdp.dev.java.net/CDDLv1.0.html  If applicable,
 * add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your
 * own identifying information: Portions Copyright [yyyy]
 * [name of copyright owner]
 */
package com.sun.xml.stream.buffer;

public abstract class AbstractCreatorProcessor {
    /**
     * Flag on a T_DOCUMENT to indicate if a fragment
     */
    protected static final int FLAG_DOCUMENT_FRAGMENT      = 1 << 0;

    /**
     * Flags on T_ELEMENT, T_ATTRIBUTE, T_NAMESPACE_ATTRIBUTE
     * to indicate namespace information is represent
     */
    protected static final int FLAG_PREFIX                 = 1 << 0;
    protected static final int FLAG_URI                    = 1 << 1;
    protected static final int FLAG_QUALIFIED_NAME         = 1 << 2;
    
    /**
     * Types of content for T_TEXT and T_COMMENT
     */
    protected static final int CONTENT_TYPE_CHAR_ARRAY        = 0;
    protected static final int CONTENT_TYPE_CHAR_ARRAY_COPY   = 1;
    protected static final int CONTENT_TYPE_STRING            = 2;
    protected static final int CONTENT_TYPE_OBJECT            = 3;

    /**
     * Types of value for T_ATTRIBUTE
     */
    protected static final int VALUE_TYPE_STRING              = 0;
    protected static final int VALUE_TYPE_OBJECT              = 1 << 3;

    /*
     * Mask for types
     */
    protected static final int TYPE_MASK                     = 0xF0;
    
    protected static final int T_END                         = 0x00;
    protected static final int T_DOCUMENT                    = 0x10;
    protected static final int T_ELEMENT                     = 0x20;
    protected static final int T_ATTRIBUTE                   = 0x30;
    protected static final int T_NAMESPACE_ATTRIBUTE         = 0x40;
    protected static final int T_TEXT                        = 0x50;
    protected static final int T_COMMENT                     = 0x60;
    protected static final int T_PROCESSING_INSTRUCTION      = 0x70;
    protected static final int T_UNEXPANDED_ENTITY_REFERENCE = 0x80;

    protected static final int T_DOCUMENT_FRAGMENT           = T_DOCUMENT | FLAG_DOCUMENT_FRAGMENT;
    
    protected static final int T_ELEMENT_U_LN_QN             = T_ELEMENT | FLAG_URI | FLAG_QUALIFIED_NAME;
    protected static final int T_ELEMENT_P_U_LN              = T_ELEMENT | FLAG_PREFIX | FLAG_URI;
    protected static final int T_ELEMENT_U_LN                = T_ELEMENT | FLAG_URI;
    protected static final int T_ELEMENT_LN                  = T_ELEMENT;
    
    protected static final int T_NAMESPACE_ATTRIBUTE_P       = T_NAMESPACE_ATTRIBUTE | FLAG_PREFIX;
    protected static final int T_NAMESPACE_ATTRIBUTE_P_U     = T_NAMESPACE_ATTRIBUTE | FLAG_PREFIX | FLAG_URI;
    protected static final int T_NAMESPACE_ATTRIBUTE_U       = T_NAMESPACE_ATTRIBUTE | FLAG_URI;
    
    protected static final int T_ATTRIBUTE_U_LN_QN           = T_ATTRIBUTE | FLAG_URI | FLAG_QUALIFIED_NAME;
    protected static final int T_ATTRIBUTE_P_U_LN            = T_ATTRIBUTE | FLAG_PREFIX | FLAG_URI;
    protected static final int T_ATTRIBUTE_U_LN              = T_ATTRIBUTE | FLAG_URI;
    protected static final int T_ATTRIBUTE_LN                = T_ATTRIBUTE;
    protected static final int T_ATTRIBUTE_U_LN_QN_OBJECT    = T_ATTRIBUTE_U_LN_QN | VALUE_TYPE_OBJECT;
    protected static final int T_ATTRIBUTE_P_U_LN_OBJECT     = T_ATTRIBUTE_P_U_LN | VALUE_TYPE_OBJECT;
    protected static final int T_ATTRIBUTE_U_LN_OBJECT       = T_ATTRIBUTE_U_LN | VALUE_TYPE_OBJECT;
    protected static final int T_ATTRIBUTE_LN_OBJECT         = T_ATTRIBUTE_LN | VALUE_TYPE_OBJECT;
    
    protected static final int T_TEXT_AS_CHAR_ARRAY          = T_TEXT;
    protected static final int T_TEXT_AS_CHAR_ARRAY_COPY     = T_TEXT | CONTENT_TYPE_CHAR_ARRAY_COPY;
    protected static final int T_TEXT_AS_STRING              = T_TEXT | CONTENT_TYPE_STRING;
    protected static final int T_TEXT_AS_OBJECT              = T_TEXT | CONTENT_TYPE_OBJECT;
    
    protected static final int T_COMMENT_AS_CHAR_ARRAY       = T_COMMENT;
    protected static final int T_COMMENT_AS_CHAR_ARRAY_COPY  = T_COMMENT | CONTENT_TYPE_CHAR_ARRAY_COPY;
    protected static final int T_COMMENT_AS_STRING           = T_COMMENT | CONTENT_TYPE_STRING;
    
    protected static final int T_END_OF_BUFFER               = -1;
    
    protected FragmentedArray<int[]> _currentStructureFragment;
    protected int[] _structure;
    protected int _structurePtr;
    
    protected FragmentedArray<String[]> _currentStructureStringFragment;
    protected String[] _structureStrings;
    protected int _structureStringsPtr;
    
    protected FragmentedArray<char[]> _currentContentCharactersBufferFragment;
    protected char[] _contentCharactersBuffer;
    protected int _contentCharactersBufferPtr;        
    
    protected FragmentedArray<Object[]> _currentContentObjectFragment;
    protected Object[] _contentObjects;
    protected int _contentObjectsPtr;        
}
