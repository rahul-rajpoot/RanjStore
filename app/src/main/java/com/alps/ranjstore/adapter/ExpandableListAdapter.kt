package com.alps.ranjstore.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import com.alps.ranjstore.R

class ExpandableListAdapter(
    private val _context: Context, // header titles
    private val _listDataHeader: List<String>,
    // child data in format of header title, child title
    private val _listDataChild: HashMap<String, List<String>>,
    private val blueColorList: ColorStateList
) : BaseExpandableListAdapter() {
    var listView: ExpandableListView? = null
    override fun getChild(groupPosition: Int, childPosititon: Int): Any {
        return _listDataChild[_listDataHeader[groupPosition]]!!.get(childPosititon)
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getChildView(
        groupPosition: Int, childPosition: Int,
        isLastChild: Boolean, convertView: View, parent: ViewGroup
    ): View {
        var convertView = convertView
        val childText = getChild(groupPosition, childPosition) as String
        if (convertView == null) {
            val infalInflater = _context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.nav_list_group_child, null)
        }
        val txtListChild = convertView
            .findViewById<View>(R.id.lblListItem) as TextView
        txtListChild.text = childText
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {

//        if (groupPosition != null){
//            if ((_listDataHeader.get(groupPosition)!=null)&&(_listDataChild.get(_listDataHeader.get(groupPosition)).size()!=null)){
//pos=_listDataChild.get(_listDataHeader.get(groupPosition)).size();
//            }
//            else {
//                pos=0;
//            }
//
//        }
        val child: List<*>? = _listDataChild[_listDataHeader[groupPosition]]
        val pos: Int
        pos = if (child != null && !child.isEmpty()) {
            _listDataChild[_listDataHeader[groupPosition]]!!.size
            // return child.size();
        } else {
            0
        }
        return pos
        //   return this._listDataChild.get(this._listDataHeader.get(groupPosition))
        //         .size();
    }

    override fun getGroup(groupPosition: Int): Any {
        return _listDataHeader[groupPosition]
    }

    override fun getGroupCount(): Int {
        return _listDataHeader.size
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    @SuppressLint("ResourceAsColor")
    override fun getGroupView(
        groupPosition: Int, isExpanded: Boolean,
        convertView: View, parent: ViewGroup
    ): View {
        var convertView = convertView
        val headerTitle = getGroup(groupPosition) as String
        if (convertView == null) {
            val infalInflater = _context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = infalInflater.inflate(R.layout.nav_list_group, null)
        }
        val lblListHeader = convertView
            .findViewById<TextView>(R.id.lblListHeader)
        //        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.text = headerTitle
        //  lblListHeader.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.arrow_down,0);
        val im = convertView.findViewById<ImageView>(R.id.eximage)
        //  int imgid=this.groupImages.get(groupPosition);
        // im.setImageResource(NavigationDrawer.groupImages[]);

        /* if (headerTitle.equals("KYC Manager"))
        {
            im.setImageResource(R.drawable.kyc);
        }*/

//        listDataHeader.add("Dashboard");
//        listDataHeader.add("My Network");
//        listDataHeader.add("E-Pin Manager");
//        listDataHeader.add("Profile Manager");
//        listDataHeader.add("Financial Report");
//        listDataHeader.add("Currency Wallet");
//        listDataHeader.add("Logout");
        if (headerTitle == "Dashboard") {
            im.setImageResource(R.drawable.home)
            im.imageTintList = blueColorList
        } else if (headerTitle == "Shop") {
            im.setImageResource(R.drawable.shop)
            im.imageTintList = blueColorList
        } else if (headerTitle == "Activate Account") {
            im.setImageResource(R.drawable.activate_account)
            im.imageTintList = blueColorList
        } else if (headerTitle == "Profile Manager") {
            im.setImageResource(R.drawable.profile_manager)
            im.imageTintList = blueColorList
        } else if (headerTitle == "My Network") {
            im.setImageResource(R.drawable.network_manager)
            im.imageTintList = blueColorList
        } else if (headerTitle == "E-Pin Manager") {
            im.setImageResource(R.drawable.kyc_manager)
            im.imageTintList = blueColorList
        } else if (headerTitle == "Financial Report") {
            im.setImageResource(R.drawable.financial_report)
            im.imageTintList = blueColorList
        } else if (headerTitle == "Currency Wallet") {
            im.setImageResource(R.drawable.current_wallet)
            im.imageTintList = blueColorList
        } else if (headerTitle.equals("Customer Support", ignoreCase = true)) {
            im.setImageResource(R.drawable.customer_support)
            im.imageTintList = blueColorList
        } else if (headerTitle.equals("Promotional Materials", ignoreCase = true)) {
            im.setImageResource(R.drawable.current_wallet)
            im.imageTintList = blueColorList
        } else if (headerTitle == "Logout") {
            im.setImageResource(R.drawable.logout)
            im.imageTintList = blueColorList
        }

//        if (isExpanded) {
//            img.setImageResource(R.drawable.group_down);
//        } else {
//            groupHolder.img.setImageResource(R.drawable.group_up);
//        }
        if (headerTitle != "Dashboard" && headerTitle != "Logout" && headerTitle != "Activate Account" && headerTitle != "Customer Support" && headerTitle != "Promotional Materials") {
            if (isExpanded) {
                lblListHeader.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.expand_less_24,
                    0
                )
            } else {
                lblListHeader.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.expand_more_24,
                    0
                )
            }
        }
        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}