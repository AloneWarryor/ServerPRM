package com.fpt.prm.mapper;

import java.util.List;

import com.fpt.prm.model.Address;

public interface AddressMapper {
	public List<Address> findAddAddress();

	public Address findAddAddressByID(int addressID);
}
